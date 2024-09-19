package DependancyInversion.PoorCode;

public class Login {
    emailOTPSender optSender = new emailOTPSender();
    PhoneOTPSender optSender2 = new PhoneOTPSender();
    public void signUp(){
        optSender.sendOtp();
        optSender2.sendOtp();
        System.out.println("signup");
    }
}
