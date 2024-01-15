package software.ujithamigara.codechallengejavaee.bo.custom;


import software.ujithamigara.codechallengejavaee.DTO.ItemDTO;
import software.ujithamigara.codechallengejavaee.bo.SuperBO;

import java.util.List;

public interface ItemBO extends SuperBO {
    List<ItemDTO> getAllItems() throws Exception;
    boolean saveItem(ItemDTO dto) throws Exception;
    boolean updateItem(ItemDTO dto) throws Exception;
    boolean deleteItem(String id) throws Exception;
    ItemDTO getItem(String itemId) throws Exception;
}
