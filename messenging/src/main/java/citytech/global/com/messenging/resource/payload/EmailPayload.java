package citytech.global.com.messenging.resource.payload;

public class EmailPayload {

    private final String from ="satishsubedi18@gmail.com";
    private String to;
    private String subject;
    private String htmlContent;

    public EmailPayload(String to, String subject, String htmlContent) {
        this.to = to;
        this.subject = subject;
        this.htmlContent = htmlContent;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    @Override
    public String toString() {
        return "EmailPayload{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                '}';
    }

    public EmailPayload() {
    }
}
