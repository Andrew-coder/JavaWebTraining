package task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Создать необходимые сущности и сымитировать изменения состояния объекта Человек» в
 * «Охотник», «Рыбак», «Грибник» в зависимости от его состояния:
 * - находится - на берегу реки,
 * - находится - на грибной поляне,
 * - видит зверя.
 * Учесть возможность наложения событий – человек находится на грибной поляне (например) и
 * увидел зверя.
 */
public class Task2 {
    public class Human implements Activity{
        List<Activity> activities;

        public Human() {
            activities = new ArrayList<>();
        }

        public void addActivity(Activity activity){
            activities.add(activity);
        }

        @Override
        public void performActivity() {
            for(Activity activity:activities){
                activity.performActivity();
            }
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
