package json;

import org.junit.Assert;
import org.junit.Test;

public class TestsForJson {

    @Test
    public void testReadJson() {
        JsonModifier jsonParser = new JsonModifier("file.json");

        Assert.assertNotNull(jsonParser);
    }

    @Test
    public void testGetValue() {
        JsonModifier jsonParser = new JsonModifier("file.json");

        String str = jsonParser.getValue("glossary.GlossDiv.GlossList.GlossEntry.GlossTerm");

        Assert.assertEquals("Standard Generalized Markup Language", str);
    }

    @Test
    public void testChangeValue() {
        JsonModifier jsonParser = new JsonModifier("file.json");

        jsonParser.changeValueParameter("glossary.GlossDiv.GlossList.GlossEntry.Acronym", "CHANGED");

        String str = jsonParser.getValue("glossary.GlossDiv.GlossList.GlossEntry.Acronym");

        Assert.assertEquals("CHANGED", str);
    }
}
