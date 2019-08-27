package com.hussein.controller;

import com.hussein.vo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Title: AddressController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/27 10:28 AM
 */
@RestController
public class AddressController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @param id 5d1453e0e4b0d6b6cadcd69f
     * @return {"id":"5d1453e0e4b0d6b6cadcd69f","address":"开元曼居酒店","addressDetail":"816房间"}
     */
    @RequestMapping("/findById/{id}")
    public Address findById(@PathVariable(name = "id") String id) {
        return getAddressById(id);
    }

    /**
     * @param address  {"id":"5d1453e0e4b0d6b6cadcd69f","address":"开元曼居酒店","addressDetail":"817房间"}
     * @return  {"id":"5d1453e0e4b0d6b6cadcd69f","address":"开元曼居酒店","addressDetail":"817房间"}
     */
    @PostMapping("/update")
    public Address update(@RequestBody Address address) {
        jdbcTemplate.update("update address set address=?,address_detail=? where id=?"
                , address.getAddress(), address.getAddressDetail(), address.getId());
        return findById(address.getId());
    }

    private Address getAddressById(@PathVariable(name = "id") String id) {
        return jdbcTemplate.queryForObject("select id,address,address_detail from address where id=?",
                new Object[]{id},
                (rs, rowNum) -> Address.builder()
                        .id(rs.getString("id"))
                        .address(rs.getString("address"))
                        .addressDetail(rs.getString("address_detail"))
                        .build());
    }

}
