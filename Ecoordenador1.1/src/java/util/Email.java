/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Caio
 */
public class Email {
    
    //Método que retorna a autenticação de sua conta de email
    public static Authenticator getAuthenticator(){
        Authenticator autenticacao = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                //Preencha com seu email e com sua senha
                return new PasswordAuthentication("ifto.tcc.teste@gmail.com", "2rasec12");
            }
        };
        return autenticacao;
    }
    
    //Método que retorna as propriedades de configuração do servidor de email
    public static Properties getPropriedades(){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP do seu servidor de email
        props.put("mail.smtp.socketFactory.port", "465"); //Porta do servidor smtp
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //Define a conexão do tipo SSL
        props.put("mail.smtp.auth", "true"); //Define que é necessário autenticação
        props.put("mail.smtp.port", "465"); //Porta do seu servidor smtp
        return props;
    }
    
    public static void enviaEmail(String remetente, String destinatario, String assunto, String mensagem) {
        Session session = Session.getInstance(getPropriedades(),getAuthenticator());
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente)); //seta o remetente
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destinatario)); //define destinatario
            message.setSubject(assunto); //define assunto
            message.setText(mensagem); // mensagem contida no email
            Transport.send(message); //envia email
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
