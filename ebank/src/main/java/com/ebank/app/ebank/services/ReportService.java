package com.ebank.app.ebank.services;


import com.ebank.app.ebank.entities.LocalClient;
import com.ebank.app.ebank.repos.InternationalClientRepo;
import com.ebank.app.ebank.repos.LocalClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.ebank.app.ebank.utils.*;




@Service
public class ReportService {


    private final String directoryPath = "C:\\E-Banking Application\\backend\\ebank\\pdf\\" ;
    private final String delimiter = ",";

    private final String lineSeparator = "\n";

    @Autowired
    private LocalClientRepo localClientRepo;


    @Autowired
    private InternationalClientRepo internationalClientRepo;


    public File generateReport(String clientType) throws IOException {
        String fileName = "ClientReport.csv" ;
        List<Tuple> records;
        if(clientType.equals("Local") ) {
            records = localClientRepo.findAllFromLocalClientDb();
        } else {
            records = internationalClientRepo.findAllFromInternationalClientDb();
        }
        return prepareReport(records , fileName);
    }




    private File prepareReport(List<Tuple> records, String fileName) {

        boolean headersAdded = false;

        var file = new File(directoryPath + "reports/" + fileName);

        try (var fw = new FileWriter(file)) {

            for (Tuple row : records) {
                if (!headersAdded) {
                    List<TupleElement<?>> elements = row.getElements();
                    for (TupleElement<?> element : elements) {
                        fw.append(element.getAlias());
                        fw.append(delimiter);
                    }
                    fw.append(lineSeparator);
                    headersAdded = true;
                }
                Object[] columns = row.toArray();
                for (Object obj : columns) {
                    if (obj != null) {
                        String text = obj.toString().replaceAll("\\R", " ");
                        if (text.contains(",")) {
                            text = text.replace(",", "");
                        }
                        fw.append(text);

                        fw.append(delimiter);
                    } else {
                        fw.append(" ");
                        fw.append(delimiter);
                    }
                }
                fw.append(lineSeparator);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
