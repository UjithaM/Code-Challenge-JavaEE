package software.ujithamigara.codechallengejavaee.bo.custom.Impl;

import software.ujithamigara.codechallengejavaee.DTO.ItemDTO;
import software.ujithamigara.codechallengejavaee.bo.custom.ItemBO;
import software.ujithamigara.codechallengejavaee.dao.DAOFactory;
import software.ujithamigara.codechallengejavaee.dao.custom.ItemDAO;
import software.ujithamigara.codechallengejavaee.entity.Item;
import software.ujithamigara.codechallengejavaee.util.Convert;

import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public List<ItemDTO> getAllItems() throws Exception {
        List<Item> items = itemDAO.getAll();
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item : items) {
            itemDTOS.add(Convert.itemEntityToDto(item));
        }
        return itemDTOS;
    }

    @Override
    public boolean saveItem(ItemDTO dto) throws Exception {
        return itemDAO.save(Convert.itemDTOToEntity(dto, null));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws Exception {
        return itemDAO.update(Convert.itemDTOToEntity(dto, null));
    }

    @Override
    public boolean deleteItem(String id) throws Exception {
        return itemDAO.delete(id);
    }
    @Override
    public ItemDTO getItem(String itemId) throws Exception {
        return Convert.itemEntityToDto(itemDAO.get(itemId));
    }
}
