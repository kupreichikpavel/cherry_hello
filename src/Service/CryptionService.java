package Service;
import Models.CryptoModel;
import Models.CryptoPaths;
import java.nio.file.Path;
import java.util.List;

public class CryptionService {
     public final FileService fileService;

    public CryptionService(FileService fileService) {
        this.fileService = fileService;
    }

    public void crypt(CryptoModel cryptoModel){
       try {
           List<String> dataFormatFile = fileService.readFromFile(Path.of(cryptoModel.getPathFrom()),false);
       }  catch (Exception e ){
           System.out.println("не прочитал");
       }
    }

    public void decrypt(CryptoModel cryptoModel) {
    }

    public void bruteForce(CryptoPaths paths) {

    }

    public void staticAnalyz(CryptoPaths paths) {
    }
}
