package citytech.global.sapatide.usecase.extractusers;
import citytech.global.sapatide.repository.user.UserEntity;
import citytech.global.sapatide.repository.user.UserRepository;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import jakarta.inject.Inject;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExtractUsersUseCase {
    private  final UserRepository userRepository;
    @Inject
    public ExtractUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void generateAndSaveExcel() throws IOException {
        List<UserEntity> users = userRepository.findAll();
        Workbook workbook = new XSSFWorkbook();
            FileOutputStream fos = new FileOutputStream("users.xlsx");
            Sheet sheet = workbook.createSheet("Users");

            // Create a header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("First Name");
            headerRow.createCell(1).setCellValue("Last Name");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("User Type");

            // Fill in user data
            int rowNum = 1;
            for (UserEntity user : users) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getFirstName());
                row.createCell(1).setCellValue(user.getLastName());
                row.createCell(2).setCellValue(user.getEmail());
                row.createCell(3).setCellValue(user.getUserType());
            }
            workbook.write(fos);
            fos.close();
    }
}
