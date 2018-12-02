package br.unisul.controlePatrimonio.patrimony;

import br.unisul.controlePatrimonio.departament.DepartamentRepository;
import br.unisul.controlePatrimonio.transfer.Transfer;
import br.unisul.controlePatrimonio.transfer.TransferRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/patrimony")
public class PatrimonyResource {

    private PatrimonyRepository patrimonyRepository;
    private DepartamentRepository departamentRepository;
    private TransferRepository transferRepository;


    public PatrimonyResource(PatrimonyRepository patrimonyRepository, DepartamentRepository departamentRepository, TransferRepository transferRepository) {
        this.patrimonyRepository = patrimonyRepository;
        this.departamentRepository = departamentRepository;
        this.transferRepository = transferRepository;
    }


    @GetMapping
    public String index(Model model) {
        model.addAttribute("patrimonies", this.patrimonyRepository.findAll());
        return "patrimony/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("patrimony", new Patrimony());
        model.addAttribute("departaments", this.departamentRepository.findAll());
        return "patrimony/create";
    }

    @PostMapping("/")
    public String store(@ModelAttribute("patrimony") Patrimony patrimony) {
        this.patrimonyRepository.save(patrimony);
        return "redirect:/patrimony";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("patrimony", this.patrimonyRepository.findById(id).orElse(null));
        return "patrimony/show";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("departaments", this.departamentRepository.findAll());
        model.addAttribute("patrimony", this.patrimonyRepository.findById(id).orElse(null));
        return "patrimony/edit";
    }

    @PutMapping("{id}")
    public String Update(@PathVariable("id") Long id, @ModelAttribute("patrimony") Patrimony patrimony) {
        if (this.patrimonyRepository.existsById(id)) {
            this.patrimonyRepository.save(patrimony);
        }
        return "redirect:/patrimony";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable("id") Long id) {
        if (this.patrimonyRepository.existsById(id)) {
            this.patrimonyRepository.deleteById(id);
        }
        return "redirect:/patrimony";
    }

    @GetMapping("/transfer/{id}")
    public String createTransfer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("transfer", new Transfer());
        model.addAttribute("departaments", this.departamentRepository.findAll());
        model.addAttribute("patrimony", this.patrimonyRepository.findById(id).orElse(null));
        return "patrimony/transfer";
    }

    @PostMapping("/transfer/")
    public String storeTransfer(@ModelAttribute("transfer") Transfer transfer) {
        Patrimony patrimony = transfer.getPatrimony();
        patrimony.setDepartment(transfer.getDepartamentDestination());
        this.transferRepository.save(transfer);
        this.patrimonyRepository.save(patrimony);

        return "redirect:/patrimony";
    }

    @GetMapping("/historic/{id}")
    public String historic(@PathVariable("id") Long id, Model model) {
        model.addAttribute("patrimony", this.patrimonyRepository.findById(id).orElse(null));
        return "patrimony/historic_movement";
    }
}
