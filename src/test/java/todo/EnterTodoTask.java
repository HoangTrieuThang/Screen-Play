package todo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

//co the implements Performable
public class EnterTodoTask implements Task {

    //save gia tri todo task khi duoc truyen vao
    List<String> listTask;
    public void enterTask(List<String> listTas){
        this.listTask=listTas;
    }

    //tao constructor theo instrumented
    public static Performable with(List<String> listTask) {
        return instrumented(EnterTodoTask.class,listTask);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        listTask.forEach((listTask)->{
            actor.attemptsTo(
                    Enter.theValue(listTask).into(TodoPage.TASK_INPUT).thenHit(Keys.ENTER)
            );
        });
    }
}
