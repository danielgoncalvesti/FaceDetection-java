import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class Detection {

		public static void main(String[] args) {

	        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	 
	        CascadeClassifier faceDetector = new CascadeClassifier();
	        faceDetector.load("haarcascades/haarcascade_frontalface_alt.xml");
	 
	        // Imagem de entrada
	        Mat image = Imgcodecs.imread(args[0]);
	 
	        // Detectando faces
	        MatOfRect faceDetections = new MatOfRect();
	        faceDetector.detectMultiScale(image, faceDetections);
	 
	        // criando um retângulo na imagem
	        for (Rect rect : faceDetections.toArray())
	        {
	            Imgproc.rectangle(image, new Point(rect.x, rect.y),
	             new Point(rect.x + rect.width, rect.y + rect.height),
	                                           new Scalar(0, 255, 0));
	        }
	 
	        // salvando a nova imagem com retângulos
	        String filename = "imagem_retangulo.jpg";
	        Imgcodecs.imwrite("c:\\"+filename, image);
	    }

	}
		
