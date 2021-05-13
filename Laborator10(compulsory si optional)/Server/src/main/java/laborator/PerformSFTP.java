package laborator;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.util.Properties;

public class PerformSFTP {
    public PerformSFTP(){}
    public void perform(){
        try{
            String user = "Daniel";
            String password = "123456";
            Properties config = new Properties();
            config.put("StrictHostKeyChecking","no");
            String host="127.0.0.1";
            JSch jsch = new JSch();
            Session session = jsch.getSession(user,host);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.put("d:\\Imagini\\SVGBarChart.svg","inbound\\SVGBarChart.svg");
            channelSftp.disconnect();
            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
