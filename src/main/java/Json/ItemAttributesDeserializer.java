package Json;

import Adventure.Item.ItemAttributes;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ItemAttributesDeserializer extends JsonDeserializer<ItemAttributes> {
  
  @Override
  public ItemAttributes deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    JsonNode node = p.getCodec().readTree(p);
    ObjectMapper mapper = (ObjectMapper) p.getCodec();
    
    ItemAttributes itemAttributes = mapper.treeToValue(node, ItemAttributes.class);
    String itemName = ((JsonParser) p).getParsingContext().getCurrentName();
    itemAttributes.setName(itemName);
    
    return itemAttributes;
  }
}
