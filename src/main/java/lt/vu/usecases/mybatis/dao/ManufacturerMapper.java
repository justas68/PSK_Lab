package lt.vu.usecases.mybatis.dao;

import java.util.List;
import lt.vu.usecases.mybatis.model.Manufacturer;
import org.mybatis.cdi.Mapper;

@Mapper
public interface ManufacturerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    int insert(Manufacturer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    Manufacturer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    List<Manufacturer> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Sun Mar 24 22:30:53 EET 2019
     */
    int updateByPrimaryKey(Manufacturer record);
}