package br.unisul.controlePatrimonio.departament;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/departament")
public class DepartamentResource {

    private DepartamentRepository departamentRepository;


    public DepartamentResource(DepartamentRepository departamentRepository) {
        this.departamentRepository = departamentRepository;
    }


    @GetMapping
    public String index(Model model) {
        model.addAttribute("departaments", this.departamentRepository.findAll());
        return "departament/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("departament", new Departament());
        return "departament/create";
    }

    @PostMapping("/")
    public String store(@ModelAttribute("departament") Departament departament) {
        this.departamentRepository.save(departament);
        return "redirect:/departament";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("departament", this.departamentRepository.findById(id).orElse(null));
        return "departament/show";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("departament", this.departamentRepository.findById(id).orElse(null));
        return "departament/edit";
    }

    @PutMapping("{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("department") Departament departament) {
        if (this.departamentRepository.existsById(id)) {
            this.departamentRepository.save(departament);
        }
        return "redirect:/departament";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable("id") Long id) {
        if (this.departamentRepository.existsById(id)) {
            this.departamentRepository.deleteById(id);
        }
        return "redirect:/departament";
    }

    @GetMapping("/list/{id}")
    public String list(@PathVariable("id") Long id, Model model) {
        model.addAttribute("departament", this.departamentRepository.findById(id).orElse(null));
        return "departament/patrimonial_list";
    }
}
