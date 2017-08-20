package org.lanqiao.rbac.repository;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.lanqiao.rbac.core.Tester;
import org.lanqiao.rbac.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;

public class UserProfileMapperTest extends Tester {
  @Autowired
  private UserProfileMapper userProfileMapper;

  @Test
  public void testSelectAll() {
    Assertions.assertThat( userProfileMapper.selectAll().size() > 0 ).isTrue();
  }

  @Test
  public void testSelectByPage() {
    PageInfo<UserProfile> info = PageHelper.startPage( 1, 10 ).doSelectPageInfo( new ISelect() {
      @Override
      public void doSelect() {
        userProfileMapper.selectAll();
      }
    } );

    System.out.println(info);
  }
}