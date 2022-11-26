package com.labcomu.orcid;

import com.labcomu.orcid.resource.Researcher;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.resilience4j.retry.annotation.Retry;
import com.labcomu.faultinjection.annotation.Throw;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v1/orcid")
@Validated
@RequiredArgsConstructor
public class OrcidController {
    private final OrcidService service;

    @GetMapping("active")
    public boolean isActive() {
        return service.isActive();
    }

    @Retry(name = "getResearcher")
    @Throw(exception = RuntimeException.class, threshold = 0.5)
    @GetMapping("researcher/{orcid}")
    public Researcher getResearcher(@NotNull @PathVariable String orcid) {
        System.out.println("[Orcid Controller] getResearcher CALLED");
        return service.getResearcher(orcid);
    }
}
