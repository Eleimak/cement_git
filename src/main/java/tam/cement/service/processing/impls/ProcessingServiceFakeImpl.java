package tam.cement.service.processing.impls;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tam.cement.dataset.TestData;
import tam.cement.model.Cadr;
import tam.cement.model.Processing;
import tam.cement.service.cadr.impls.CadrServiceFakeImpl;
import tam.cement.service.processing.interfaces.IProcessingService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ProcessingServiceFakeImpl implements IProcessingService {


    final private CadrServiceFakeImpl cadrService;
    final private TestData data;

    private final Tesseract tesseract;
    private final     String testdata;
    private final     String dir;

    @Autowired
    public ProcessingServiceFakeImpl(CadrServiceFakeImpl cadrService, TestData data) throws IOException, TesseractException {
        this.cadrService = cadrService;
        this.data = data;
        String userDirectory = new File("").getAbsolutePath();
        this.testdata  = userDirectory + "/testdata";
        this.tesseract =  new Tesseract();
        this.dir = userDirectory ;
        tesseract.setDatapath(this.testdata);
        tesseract.setLanguage("digits_comma");
      //  tesseract.setPageSegMode(1);
       // tesseract.setOcrEngineMode(1);
        this.identifyDirectory();
    }

    public List<Processing> identifyDirectory() throws IOException, TesseractException{

        List<Cadr>  cadrs = cadrService.getAll();
        List<Processing> processings = new ArrayList<>();
        AtomicReference<String> recognition = new AtomicReference<>("Failed");

        cadrs.stream().forEach(cadr -> {
            try {
                recognition.set(this.identifyOne(cadr.getPath()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TesseractException e) {
                e.printStackTrace();
            }
            System.out.println(recognition.toString());
            Processing processing = new Processing( cadr,  recognition.toString().replace("\n","") );
           processing.setQuality(100);
           processing.setSuccess(true);
           processing.setTime(LocalDateTime.now());

            processings.add(processing);

        });
        this.data.setProcessings(processings);
        return  processings;
    }


    public String identifyOne(String img) throws IOException, TesseractException {

        String userDirectory = new File("").getAbsolutePath();
       // System.out.println(userDirectory);
       // String url =  img;
        String url = this.dir + "/" + img;
       // BufferedImage image = ImageIO.read(new File(url));
        //System.out.println(image.getHeight());

        return this.thesaurus(url);
    }

    private String thesaurus(String url) throws TesseractException {
        System.out.println(url);
        File file = new File(url);
        String text  = tesseract.doOCR(file);

        if (text != null) {
            text = text.replace(" ","");
        }

        return (text != null) ? text : "File not found";
    }




    @Override
    public Processing create(Processing processing) {
        return null;
    }

    @Override
    public Processing get(String id) {
        return null;
    }

    @Override
    public Processing update(Processing processing) {
        return null;
    }

    @Override
    public Processing delete(String id) {
        return null;
    }

    @Override
    public List<Processing> getAll() {
        return data.getProcessings();
    }
}
