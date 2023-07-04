package todo;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TodoPage {
    public static final Target TASK_INPUT = Target.the("input_field").located(By.cssSelector(".new-todo"));
}
