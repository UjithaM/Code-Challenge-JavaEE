package software.ujithamigara.codechallengejavaee.bo.custom.Impl;

import software.ujithamigara.codechallengejavaee.DTO.ItemDTO;
import software.ujithamigara.codechallengejavaee.bo.custom.ItemBO;

import java.util.List;

public class ItemBOImpl implements ItemBO {

    @Override
    public List<ItemDTO> getAllItems() throws Exception {
        return null;
    }

    @Override
    public boolean saveItem(ItemDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteItem(String id) throws Exception {
        return false;
    }
}
