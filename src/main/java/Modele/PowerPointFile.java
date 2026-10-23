package Modele;

import org.apache.poi.hslf.usermodel.*;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Color;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PowerPointFile implements Fichier {
    private String file;

    public PowerPointFile(String file) {
        this.file = file;
    }

    @Override
    public void readFile() throws IOException {

    }

    @Override
    public void writeFile() throws IOException {
        //Création d'un slide ppt vide
        HSLFSlideShow ppt = new HSLFSlideShow();

        //Ajout de slides
        HSLFSlide slide1 = ppt.createSlide();
        HSLFSlide slide2 = ppt.createSlide();

        /* Problème de dépendance*/
        //BackGround
        HSLFSlideMaster master = ppt.getSlideMasters().get(0);
        HSLFFill fill = master.getBackground().getFill();
        HSLFPictureData bg = ppt.addPicture(new File("src/main/java/ressources/texte/background-ppt.jpg"), PictureData.PictureType.PNG);
        //fill.setFillType(HSLFFill.FILL_PICTURE);
        fill.setPictureData(bg);


        //Titre
        HSLFTextBox title = slide1.addTitle();
        title.setText("Les méthodes de l'archéologie");

        //Formatage de texte
        HSLFTextBox txt = new HSLFTextBox();
        txt.setText("Le diagnostic archéologique");
        txt.setAnchor(new java.awt.Rectangle(300, 100, 300, 50));

        slide2.addShape(txt);

        //Insertion d'une image
        HSLFPictureData pd = ppt.addPicture(new File("src/main/java/ressources/texte/chantier-diag.jpg"), PictureData.PictureType.JPEG);
        HSLFPictureShape pictNew = new HSLFPictureShape(pd);
        pictNew.setAnchor(new java.awt.Rectangle(100, 100, 200, 300));
        slide2.addShape(pictNew);

        //save changes in a file
        try (FileOutputStream out = new FileOutputStream(file); ppt) {
            ppt.write(out);
        }
    }
}
