package DependancyInversion.Improvedcode;

public class Login {
    OtpSender optSender = new emailOTPSender();
    OtpSender optSender2 = new PhoneOTPSender();
    public void signUp(){
        optSender.sendOtp();
        optSender2.sendOtp();
        System.out.println("signup");
    }
}
