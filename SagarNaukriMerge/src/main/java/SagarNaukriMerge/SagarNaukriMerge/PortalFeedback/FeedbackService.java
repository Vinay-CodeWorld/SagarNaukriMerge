package SagarNaukriMerge.SagarNaukriMerge.PortalFeedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;

@Service
public class FeedbackService {
@Autowired
FeedbackRepository feedbackRepository;

public FeedbackEntity UserFeedback(String name,String email,String words) throws IOException
{
     FeedbackEntity entity = new FeedbackEntity();
     entity.setName(name);
     entity.setEmail(email);
     entity.setWords(words);
     return feedbackRepository.save(entity);
}
}
