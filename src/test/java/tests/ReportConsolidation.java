package tests;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static steps.CCreportSteps.writeToFile;

/**
 * Created by abarabas on 11/22/16.
 */
public class ReportConsolidation {

    private static String fileName = "finalReport.html";
    private static String folderPath = "report";


    @Test()
    public static void consolidateReports() throws IOException {

        Document resultHtml = Jsoup.parse("<table border=\"1\"></table>");
        generateSummaryHtmlFile();
        attachEachFileToResultHtml(resultHtml, new File(folderPath));
        addBordersAndBackgroundColor(resultHtml);

        writeToFile(resultHtml, fileName);
    }

    private static void generateSummaryHtmlFile() throws IOException {
        Document resultHtml = Jsoup.parse("<table border=\"1\"></table>");

        for (File eachReportFile : new File(folderPath).listFiles()) {

            Document eachReportParsed = Jsoup.parse(eachReportFile, "UTF-8");

            for (Element eachRow : eachReportParsed.body().getElementsByTag("tr")) {

                if (!eachRow.getElementsMatchingText("pass").isEmpty()) {
                    appendRowToDocument(resultHtml, eachRow, eachReportFile.getName());
                }
            }
        }

        writeToFile(resultHtml, "report/1-Summary.html");
    }

    private static void appendRowToDocument(Document resultHtml, Element eachRow, String teamName) {
        String persentOfTotalTests = eachRow.getElementsByTag("td").get(2).text();

        resultHtml.getElementsByTag("table").get(0).append(
                "<tr>" +
                        "<td align=\"right\">" + teamName.subSequence(0, teamName.indexOf('.')) + "</td>" +
                        "<td align=\"right\">" + persentOfTotalTests + "</td>" +
                        "</tr>"
        );

    }

    private static void attachEachFileToResultHtml(Document resultHtml, File reportFolder) throws IOException {
        for (File eachReportFile : reportFolder.listFiles()) {
            resultHtml.getElementsByTag("table").get(0).appendChild(Jsoup.parse("<th>" + eachReportFile.getName().subSequence(0, eachReportFile.getName().indexOf('.')) + "</th>").body());
            resultHtml.getElementsByTag("table").get(0).appendChild(Jsoup.parse(eachReportFile, "UTF-8").body());

        }
    }

    private static void addBordersAndBackgroundColor(Document resultHtml) {
        resultHtml.getElementsByTag("head").append("<style>\n" +
                "   table, th, td {\n" +
                "    border: 1px solid black;\n" +
                "    background-color: rgba(0, 0, 0, 0.16);\n" +
                "   }\n" +
                "  </style>");
    }


}
