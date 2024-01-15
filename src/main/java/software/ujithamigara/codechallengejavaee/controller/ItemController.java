package software.ujithamigara.codechallengejavaee.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import software.ujithamigara.codechallengejavaee.DTO.ItemDTO;
import software.ujithamigara.codechallengejavaee.bo.BOFactory;
import software.ujithamigara.codechallengejavaee.bo.custom.ItemBO;

import java.io.IOException;
import java.util.logging.Level;

@WebServlet(name = "item", urlPatterns = "/item")
public class ItemController extends HttpServlet {
    ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var writer = resp.getWriter();
        if (req.getContentType() == null ||
                !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            try {
                Jsonb jsonb = JsonbBuilder.create();
                var itemDTO = jsonb.fromJson(req.getReader(), ItemDTO.class);
                writer.println(itemBO.saveItem(itemDTO));
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var writer = resp.getWriter();
        String itemId = req.getParameter("itemId");
        if (itemId == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else if (itemId.equals("all")) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String json =  objectMapper.writeValueAsString(itemBO.getAllItems());;
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            try {
                var item = itemBO.getItem(itemId);
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(item);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var writer = resp.getWriter();
        String id = req.getParameter("itemId");
        if (id == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            try {
                Jsonb jsonb = JsonbBuilder.create();
                var itemDTO = jsonb.fromJson(req.getReader(), ItemDTO.class);
                writer.println(itemBO.updateItem(itemDTO));
            } catch (Exception e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("itemId");
        var writer = resp.getWriter();
        if (id == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            try {
                writer.println(itemBO.deleteItem(id));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
