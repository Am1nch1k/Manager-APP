package ag.selm.manager.controller;

import ag.selm.manager.entity.Product;
import ag.selm.manager.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/catalogue/products")
public class ProductsController {

    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping(value = "ping" )
    public String pongName(){
        return "pong";
    }

    @GetMapping("/catalogue/products/index")
    public String voidHello(){
        return "c";
    }

    @GetMapping("/list")
    public String getProductsList(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("newProduct", new Product()); // Для формы добавления
        return "catalogue/products/list";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("productId") int productId,
                                RedirectAttributes redirectAttributes) {
        try {
            productRepository.deleteById(productId);
            redirectAttributes.addFlashAttribute("message", "Товар успешно удален");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при удалении товара");
        }
        return "redirect:/catalogue/products/list";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("newProduct") Product product,
                             RedirectAttributes redirectAttributes) {
        try {
            if (product.getTitle() == null || product.getTitle().trim().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "Название товара не может быть пустым");
                return "redirect:/catalogue/products/list";
            }

            productRepository.save(product);
            redirectAttributes.addFlashAttribute("message", "Товар успешно добавлен");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при добавлении товара");
        }
        return "redirect:/catalogue/products/list";
    }

    @PostMapping("/select")
    public String selectProduct(@RequestParam("productId") int productId,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        productRepository.findById(productId).ifPresentOrElse(
                product -> model.addAttribute("selectedProduct", product),
                () -> redirectAttributes.addFlashAttribute("error", "Товар не найден")
        );
        return "redirect:/catalogue/products/list";
    }
}