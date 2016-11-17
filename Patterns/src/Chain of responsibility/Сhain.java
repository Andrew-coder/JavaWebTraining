abstract class Logger {
    int priority;
    Logger next;

    public Logger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    void writeMessage(String message, int level) {
        if(level<=priority){
            write(message);
        }
        if(next!=null){
            next.writeMessage(message, level);
        }
    }

    abstract void write(String message);
}

class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

class SMSLogger extends Logger {
    public SMSLogger(int priority) {
        super(priority);
    }
    void write(String message) {
        System.out.println("sms: " + message);
    }
}

class FileLogger extends Logger {
    public FileLogger(int priority) {
        super(priority);
    }
    void write(String message) {
        System.out.println("write in file: " + message);
    }
}

class EmailLogger extends Logger {
    public EmailLogger(int priority) {
        super(priority);
    }
    void write(String message) {
        System.out.println("e-mail message: " + message);
    }
}

class Main {
    public static void main(String[] args) {
        Logger smsLogger = new SMSLogger(1);
        Logger fileLogger = new FileLogger(2);
        Logger emailLogger = new EmailLogger(3);
        smsLogger.setNext(fileLogger);
        fileLogger.setNext(emailLogger);
        smsLogger.writeMessage("error occured!",Level.ERROR);
        smsLogger.writeMessage("debug logs",Level.DEBUG);
        smsLogger.writeMessage("everything is OK",Level.INFO);
    }
}