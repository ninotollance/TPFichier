package Modele;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelFile implements Fichier {

    private String file;
    private List<PiloteF1> pilotes;

    public ExcelFile(String file, List<PiloteF1> pilotes) {
        this.file = file;
        this.pilotes = pilotes;
    }

    @Override
    public void readFile() throws IOException {
        FileInputStream in = new FileInputStream(new File(file));
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.STRING) {
                    System.out.print(cell.getStringCellValue() + "\t");
                }
                if (cell.getCellType() == CellType.NUMERIC) {
                    System.out.print(cell.getNumericCellValue() + "\t");
                }
            }
            System.out.println();
        }
        workbook.close();
        in.close();
    }

    @Override
    public void writeFile() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        //creer une feuille de calcul

        XSSFSheet sheet1 = workbook.createSheet("StatsPilotes");

        Object[][] data = new Object[pilotes.size() + 1][];
        data[0] = new Object[]{
                "Nom", "Prénom", "Écurie", "Victoire", "Podium", "Championnat"
        };
        int i = 1;
        for (PiloteF1 p : pilotes) {
            data[i++] = new Object[]{p.getNom(), p.getPrenom(), p.getEcurie(),
                    p.getVictoire(), p.getPodium(), p.getChampionnat()};
        }
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(new XSSFColor(new java.awt.Color(127, 0, 128), new DefaultIndexedColorMap()));

        int rowNb = 0;
        for (Object[] pilote : data) {

            Row row = sheet1.createRow(++rowNb);
            int colonneNb = 0;

            for (Object champ : pilote) {

                Cell cell = row.createCell(++colonneNb);

                cell.setCellStyle(style);

                if (champ instanceof String) {
                    cell.setCellValue((String) champ);
                } else if (champ instanceof Integer) {
                    cell.setCellValue((Integer) champ);
                }
            }
        }
        FileOutputStream out = new FileOutputStream(new File(file));
        workbook.write(out);
        out.close();
    }
}
