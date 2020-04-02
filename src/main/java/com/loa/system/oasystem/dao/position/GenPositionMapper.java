package com.loa.system.oasystem.dao.position;

import com.loa.system.oasystem.entity.position.GenPosition;
import com.loa.system.oasystem.entity.position.GenPositionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GenPositionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    long countByExample(GenPositionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    int deleteByExample(GenPositionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Short posid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    int insert(GenPosition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    int insertSelective(GenPosition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    GenPosition selectOneByExample(GenPositionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    GenPosition selectOneByExampleSelective(@Param("example") GenPositionExample example, @Param("selective") GenPosition.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    List<GenPosition> selectByExampleSelective(@Param("example") GenPositionExample example, @Param("selective") GenPosition.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    List<GenPosition> selectByExample(GenPositionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    GenPosition selectByPrimaryKeySelective(@Param("posid") Short posid, @Param("selective") GenPosition.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    GenPosition selectByPrimaryKey(Short posid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") GenPosition record, @Param("example") GenPositionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") GenPosition record, @Param("example") GenPositionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(GenPosition record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table position
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(GenPosition record);

    /**
     * 查询所有岗位信息
     * @return
     */
    List<GenPosition> selectAll();

}