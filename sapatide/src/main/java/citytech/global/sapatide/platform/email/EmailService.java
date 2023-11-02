package citytech.global.sapatide.platform.email;

public class EmailService {
        private String to;
        private String htmlContent;
        public EmailService(String to, String htmlContent) {
            this.to = to;
            this.htmlContent = htmlContent;
        }
        public String getTo() {
            return to;
        }
        public void setTo(String to) {
            this.to = to;
        }
        public String getHtmlContent() {
            return htmlContent;
        }
        public void setHtmlContent(String htmlContent) {
            this.htmlContent = htmlContent;
        }
        @Override
        public String toString() {
            return "EmailHandler{" +
                    ", to='" + to + '\'' +
                    ", htmlContent='" + htmlContent + '\'' +
                    '}';
        }
    }

