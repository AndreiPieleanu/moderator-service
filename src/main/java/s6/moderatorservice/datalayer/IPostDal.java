package s6.moderatorservice.datalayer;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import s6.moderatorservice.datalayer.entities.Post;

import java.util.List;

@Repository
public interface IPostDal extends JpaRepository<Post, Integer> {
    @Query("select p from Post p where p.userId=:#{#userId}")
    List<Post> getAllPostsOfUser(Integer userId);
    @Query("select p from Post p where p.isOffensive=true")
    List<Post> getAllFlaggedPosts();
}
