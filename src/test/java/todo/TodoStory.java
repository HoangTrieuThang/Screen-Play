package todo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

@RunWith(SerenityRunner.class)
public class TodoStory {
    @Managed
    WebDriver driver;
    List<String> listTask = Arrays.asList("viec01", "viec02", "viec03");


    Actor actor = new Actor("Tom");

    @Before
    public void abilitiesActor(){
        actor.can(BrowseTheWeb.with(driver));
        actor.can((Consequence) EnterTodoTask.with(listTask));

    }

    @Test
    public void show_list_task_todo(){
        actor.wasAbleTo(Open.url("https://todomvc.com/examples/dojo/"));
        actor.attemptsTo(
                EnterTodoTask.with(listTask)
//                Refresh.webPage()
        );
    }
}
