package ui.menu;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResultsWindow{

    JFrame f;
    public ResultsWindow() throws IOException {

        f=new JFrame();
        String[][] data = this.ReadFromResults();

        if(data[0][0] == null){

            JLabel label = new JLabel("Nem talalhato eredmeny");
            f.add(label);
        }else{
            String[] column ={"Idopont","Jatekos neve","Ellenfel erossege","Eredmeny","Szerzett pont","Ellenfel pontja"};
            JTable jt=new JTable(data,column);
            jt.setBounds(30,40,200,300);
            JScrollPane sp=new JScrollPane(jt);
            this.ReadFromResults();
            f.add(sp);
        }


        f.setTitle("Játék eredmények");
        f.setSize(600,400);
        f.setVisible(true);
    }
    private String[][] ReadFromResults() throws IOException {

        String[][] results = new String[40][6];
        FileReader fr = new FileReader("results.txt");
        BufferedReader br = new BufferedReader(fr);
        int index = 0;
        while (true) {
            String line = br.readLine();
            if (line == null) break;

            String[] lineBreak = line.split(";");
            for(int i = 0;i<6;i++){
                results[index][i] = lineBreak[i];
            }
            index++;
        }
        br.close();
        return results;

    }
}

