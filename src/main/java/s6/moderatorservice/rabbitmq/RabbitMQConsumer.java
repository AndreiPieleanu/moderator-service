package s6.moderatorservice.rabbitmq;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import s6.moderatorservice.datalayer.IPostDal;
import s6.moderatorservice.datalayer.entities.Post;
import s6.moderatorservice.dto.PostCreatedEvent;
import s6.moderatorservice.dto.PostUpdatedEvent;
import s6.moderatorservice.service.ModeratorService;

@Service
@AllArgsConstructor
public class RabbitMQConsumer {
    private ModeratorService moderatorService;
    private IPostDal postDal;

    @RabbitListener(queues = "post-create-queue")
    public void handlePostCreatedEvent(PostCreatedEvent event) {
        // Call the function to check if the post is offensive
        Post post = Post.builder().text(event.getText()).userId(event.getUserId()).build();
        if (moderatorService.isOffensive(event.getText())) {
            System.out.println("Offensive post detected: " + event.getText());
            post.setIsOffensive(true);
            // Handle the offensive post (e.g., flag it, remove it, etc.)
        } else {
            System.out.println("Non-offensive post: " + event.getText());
        }
        postDal.save(post);
    }

    @RabbitListener(queues = "post-update-queue")
    public void handlePostUpdatedEvent(PostUpdatedEvent event) {
        // Check if the updated post is offensive
        Post post = Post.builder().text(event.getText()).userId(event.getUserId()).build();
        if (moderatorService.isOffensive(event.getText())) {
            System.out.println("Offensive updated post detected: " + event.getText());
            // Handle the offensive post
        } else {
            System.out.println("Non-offensive updated post: " + event.getText());
        }
        postDal.save(post);
    }
}
