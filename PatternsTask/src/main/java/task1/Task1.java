package task1;

/**
 * Создать необходимые сущности и сымитировать изменения состояния объекта Человек» в
 * «Охотник», «Рыбак», «Грибник» в зависимости от его состояния:
 * - находится - на берегу реки,
 * - находится - на грибной поляне,
 * - видит зверя.
 */
public class Task1 {
    public class Human implements Activity{
        Activity activity;

        public void setActivity(Activity activity) {
            this.activity = activity;
        }

        public void performActivity() {
            activity.performActivity();
        }
    }

    public interface Activity{
        public void performActivity();
    }

    public class Hunter implements Activity{
        public void performActivity() {
            System.out.println("Hunting...");
        }
    }

    public class Fisher implements Activity{
        public void performActivity() {
            System.out.println("Fishing...");
        }
    }

    public class Mushroomer implements Activity{
        public void performActivity() {
            System.out.println("Collecting mushrooms...");
        }
    }

}
