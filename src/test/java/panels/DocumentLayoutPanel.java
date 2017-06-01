package panels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.YahooPage;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;


import java.util.logging.*;

/**
 * Created by im going to use this on 3/8/2016.
 */
public class DocumentLayoutPanel extends YahooPage {


    private static By fieldRow = By.xpath(".//td[@class = \"documentEditTableColumn\"]");
    private static By fieldNamesPaths = By.xpath(".//td[contains(@id, \"_nameCell\")]");
    private static By fieldValuesPaths = By.xpath(".//td[@class=\"viewFieldValueProfile\"]/*[1]");

    //private static final Logger LOG1 = LoggerFactory.getLogger(DocumentLayoutPanel.class.getSimpleName());



    public HashMap<String, String> getLayoutFieldsAndValues() throws Exception {


       /* Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("filename.txt"), "utf-8"));*/
        /*            writer.write("."+fieldName+"^\n");*/

        waitForPageLoaded();
        switchToDocumentLayoutFrame();
        List<WebElement> fieldRows = getElements(fieldRow);

        for(WebElement row : fieldRows){

            String fieldNameText = row.findElement(fieldNamesPaths).getText();
            String fieldName = fieldNameText.substring(0,fieldNameText.length() -1);

            String fieldValue;
            WebElement value = row.findElement(fieldValuesPaths);
            if(value.getAttribute("id").contains("checkBox")){
                fieldValue = value.getAttribute("aria-checked");
            } else {
                fieldValue = value.getText();
            }
            System.out.println(fieldName + fieldValue);
        }
        //writer.close();

        return null;
    }

    public RelativityProcessingDocument getRelativityDocumentLayoutValues() throws NoSuchFieldException, IllegalAccessException {
        waitForPageLoaded();
        switchToDocumentLayoutFrame();
        RelativityProcessingDocument document = new RelativityProcessingDocument();
        List<WebElement> fieldRows = getElements(fieldRow);
        int i =0;
        Field[] fields = document.getClass().getDeclaredFields();
        for(WebElement row : fieldRows){
            /*String fieldNameText = row.findElement(fieldNamesPaths).getText();
            String fieldName = fieldNameText.substring(0,fieldNameText.length() -1).replaceAll("[\\s/()]" ,"_");*/
            String fieldValue;
            WebElement value = row.findElement(fieldValuesPaths);
            if(value.getAttribute("id").contains("checkBox")){
                fieldValue = value.getAttribute("aria-checked");
            } else {
                fieldValue = value.getText();
            }
            Field ourField = document.getClass().getDeclaredField(fields[i].getName());
            ourField.set(document, fieldValue);
            i++;
        }
        return document;
    }










    public String format(LogRecord record){
            return record.getMessage() + "\r\n";
    }


    public void switchToDocumentLayoutFrame(){
        selectDefaultFrame();
        selectFrame("profileAndPaneCollection");
        selectFrame("documentProfile");
    }



    //*[@id="_documentProfileEditor__kCuraScrollingDiv_dynamicViewRenderer_ctl01_textBox_readOnlyValue"]
    //*[@id="_documentProfileEditor__kCuraScrollingDiv_dynamicViewRenderer_ctl02_textBox_readOnlyValue"]
    //*[@id="_documentProfileEditor__kCuraScrollingDiv_dynamicViewRenderer_ctl03_textBox_readOnlyValue"]




    @Override
    public String getBaseUrl() {
        return null;
    }

    @Override
    protected By getUniqueElement() {
        return null;
    }
}
