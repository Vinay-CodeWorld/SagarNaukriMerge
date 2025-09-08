package SagarNaukriMerge.SagarNaukriMerge.PortalFeedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeedbackController {
    @Autowired
    FeedbackRepository repository;
    @RequestMapping("/feedback")
    public String feedbackform(Model model)
    {
        return "Homepage/Feedback";
    }

    @PostMapping("/submitFeedback")
    public String feedbackdatabasesubmission(@ModelAttribute ("feedback") FeedbackEntity data ,Model model)
    {
        FeedbackEntity feed=new FeedbackEntity();
        feed.setName(data.getName());
        feed.setEmail(data.getEmail());
        feed.setWords(data.getWords());
        repository.save(feed);
        model.addAttribute("Saved","Thanks for your feedback");
        return "Homepage/Feedback";
    }
}
