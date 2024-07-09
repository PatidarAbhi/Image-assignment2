

import org.example.Adapter.AIService;
import org.example.Adapter.AIServiceImpl;
import org.example.Adapter.BackgroundRemovalService;
import org.example.Adapter.BackgroundRemovalServiceAdapter;
import org.example.command.*;
import org.example.decorator.CommandLoggingDecorator;
import org.example.observer.ImageProcessingOperation;
import org.example.observer.OperationLogger;
import org.example.service.ThirdPartyBackgroundRemovalService;
import org.example.strategy.CreditCardPaymentStrategy;
import org.example.strategy.PayPalPaymentStrategy;
import org.example.strategy.PaymentContext;

public class Main {
    public static void main(String[] args) {
        BackgroundRemovalService backgroundRemovalService = new BackgroundRemovalServiceAdapter(new ThirdPartyBackgroundRemovalService());

        AIService aiService = new AIServiceImpl();

        Command resizeCommand = new ResizeCommand("image.jpg", 800, 600);
        Command extendCommand = new ExtendCommand("image.jpg", "right", 300, aiService);
        Command cropCommand = new CropCommand("image.jpg", 10, 10, 50, 50);
        Command removeBgCommand = new RemoveBackgroundCommand("image.jpg", backgroundRemovalService);

        ImageProcessingOperation operation = new ImageProcessingOperation();
        operation.addObserver(new OperationLogger());

        CommandLoggingDecorator loggingResizeCommand = new CommandLoggingDecorator(resizeCommand);
        CommandLoggingDecorator loggingExtendCommand = new CommandLoggingDecorator(extendCommand);
        CommandLoggingDecorator loggingCropCommand = new CommandLoggingDecorator(cropCommand);
        CommandLoggingDecorator loggingRemoveBgCommand = new CommandLoggingDecorator(removeBgCommand);

        operation.executeOperation(loggingResizeCommand);
        operation.executeOperation(loggingExtendCommand);
        operation.executeOperation(loggingCropCommand);
        operation.executeOperation(loggingRemoveBgCommand);

        CompositeCommand compositeCommand = new CompositeCommand();
        compositeCommand.addCommand(new RemoveBackgroundCommand("image.jpg", backgroundRemovalService));
        compositeCommand.addCommand(new ResizeCommand("image.jpg", 800, 600));


        Command storeGoogleDriveCommand = new StoreCommand("google-drive", "/MyImages/result.jpg", "image.jpg", "image.jpg");

        Command storeS3Command = new StoreCommand("aws-s3", "mybucket", "result.jpg", "image.jpg");

        PaymentContext paymentContext = new PaymentContext();
        paymentContext.setPaymentStrategy(new CreditCardPaymentStrategy());
        paymentContext.executePayment(50.00);

        paymentContext.executePayment(100.00);
        paymentContext.setPaymentStrategy(new PayPalPaymentStrategy());
    }
}