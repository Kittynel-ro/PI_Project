package org.example;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.Timer;

import static org.example.GenerateQRCode.generateQRCode;
import static org.example.ReadQRcode.readQRcode;

public class GUI extends JFrame {

    List < Student > students;
    int poz = 12;
    Timer t;
    JLabel lTitlu;
    JLabel lcurAtt;
    JLabel QR_Code;
    JTextField tfTitle;
    JTextField tfcurAtt;

    JButton bPrev;
    JButton bNext;
    JButton bAdd;

    public GUI(File file) throws IOException {

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setTitle("Gestiune prezente");
        this.setSize(590, 360);

        lTitlu = new JLabel("Nume");
        lTitlu.setPreferredSize(new Dimension(65,12));
        lTitlu.setHorizontalAlignment(SwingConstants.RIGHT);
        tfTitle = new JTextField(22);

        lcurAtt = new JLabel("Prezente");
        lcurAtt.setPreferredSize(new Dimension(65,12));
        lcurAtt.setHorizontalAlignment(SwingConstants.RIGHT);
        tfcurAtt = new JTextField(22);

        ImageIcon qrC = new ImageIcon("src/main/java/Quote.png");
        QR_Code = new JLabel(qrC);

        bPrev = new JButton("Previous");
        bNext = new JButton("Next");
        bAdd = new JButton("Send Email");

        JPanel sus = new JPanel(new BorderLayout());
        JPanel mijloc = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel data = new JPanel(new FlowLayout(FlowLayout.LEFT));

        data.add(lTitlu);
        data.add(tfTitle);
        data.add(lcurAtt);
        data.add(tfcurAtt);
        data.setPreferredSize(new Dimension(350, 90));
        sus.add(data, BorderLayout.WEST);
        sus.add(QR_Code, BorderLayout.EAST);
        this.add(sus);


        mijloc.add(bPrev);
        mijloc.add(bNext);
        mijloc.add(bAdd);
        mijloc.setPreferredSize(new Dimension(350, 65));
        this.add(mijloc);

        autoUpdate(2);
        sendEmail();

    }
    class rt extends TimerTask{
        public void run() {

            try {
                String  qcip = "src/main/java/Quote.png";
                String value = "https://docs.google.com/forms/d/e/1FAIpQLScwlvSfs0BtsiDwwuYs2AXlKXqp99DWrigcf3JvDDXFfoRrjQ/viewform?usp=sf_link";
                value += poz;
                poz += 1;
                generateQRCode(value,200, 200, qcip);
            } catch (Exception ex) {
                System.out.println("Could not generate QR Code" + ex);
            }

            //prints if the QR code is generated
            System.out.println("QR Code created successfully.");

            ImageIcon img = new ImageIcon("src/main/java/Quote.png");
            img.getImage().flush();
            QR_Code.setIcon(img);
            try {
                readQR();
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            t.cancel();
            autoUpdate(2);
        }
    }
    public void autoUpdate(int seconds) {
        t = new Timer();

        t.schedule(new rt(), seconds * 1000);
    }

    public void readQR() throws NotFoundException, IOException {
        String  path  =  "src/main/java/Quote.png";
        String  charset  =  "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap  =  new HashMap<EncodeHintType,  ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION,  ErrorCorrectionLevel.L);
        String qrData = readQRcode(path,  charset,  hintMap);
        System.out.println(qrData.substring(0, qrData.length() - 2));
    }

    public void sendEmail(){
        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String fromEmail = ""; //requires valid gmail id
                final String password = ""; // correct password for gmail id
                final String toEmail = "razvan.hinoveanu02@e-uvt.ro"; // can be any email id

                System.out.println("TLSEmail Start");
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
                props.put("mail.smtp.port", "587"); //TLS Port
                props.put("mail.smtp.auth", "true"); //enable authentication
                props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

                Authenticator auth = new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                    }
                };
                Session session = Session.getInstance(props, auth);

                EmailUtil.sendEmail(session, toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body");

            }
        });

    }
}
