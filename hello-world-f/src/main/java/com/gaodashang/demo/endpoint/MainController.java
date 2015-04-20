package com.gaodashang.demo.endpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * comments.
 *
 * @author eva
 */

@RestController
public class MainController {

    private final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/uploadify")
    @ResponseBody
    public void uploadify(@RequestParam("token") String token, @RequestParam("mm") String mm, @RequestParam("file") MultipartFile file) {
        logger.debug("token: " + token);
        logger.debug("mm: " + mm);
        logger.debug("file name: " + file.getOriginalFilename());
    }
}
