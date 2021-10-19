package uz.pdp.springbootjpa.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.pdp.springbootjpa.entity.*;
import uz.pdp.springbootjpa.entity.enums.RoleName;
import uz.pdp.springbootjpa.repository.*;

@Component
public class DataLoader implements CommandLineRunner {
    @Value("${spring.sql.init.mode}")
    private String mode;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    DefectRepository defectRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductWithAmountRepository productWithAmountRepository;

    @Autowired
    RejectRepository rejectRepository;

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    TransferRepository transferRepository;

    @Override
    public void run(String... args) throws Exception {
        if (mode.equals("always")){
            Role roleDirector = roleRepository.save(new Role(RoleName.ROLE_DIRECTOR));
            Role roleManager = roleRepository.save(new Role(RoleName.ROLE_MANAGER));
            Role roleSeller = roleRepository.save(new Role(RoleName.ROLE_SELLER));
            User director = userRepository.save(new User(
                    "director",
                    "123",
                    "director",
                    "director",
                    roleDirector
            ));
            User manager = userRepository.save(new User(
                    "manager",
                    "456",
                    "manager",
                    "manager",
                    roleManager
            ));
            User seller = userRepository.save(new User(
                    "seller",
                    "789",
                    "seller",
                    "seller",
                    roleSeller
            ));
            Warehouse mainSklad = warehouseRepository.save(new Warehouse(
                    "mainWarehouse",
                    "Uy",
                    manager
            ));
            Shop shop1 = shopRepository.save(new Shop("shop1", "NEXT", seller));
            Warehouse shop1Warehouse = warehouseRepository.save(new Warehouse(
                    shop1.getName()+" Warehouse",
                    shop1.getAddress(),
                    shop1
            ));

            Category chexolCategory = categoryRepository.save(new Category("Chexol"));
            Category naushnikCategory = categoryRepository.save(new Category("Naushnik"));

            Brand samsung = brandRepository.save(new Brand("Samsung"));
            Brand lg = brandRepository.save(new Brand("LG"));

            Product naushnik = productRepository.save(new Product(
                    "naushnik",
                    "Daxshat naushnik",
                    100.0,
                    150.0,
                    100,
                    naushnikCategory,
                    samsung
            ));
            Product chexol = productRepository.save(new Product(
                    "chexol",
                    "Daxshat chexol",
                    50.0,
                    80.0,
                    100,
                    chexolCategory,
                    lg
            ));
            Transfer mainSkladgaKirim = transferRepository.save(new Transfer(
                    mainSklad,
                    true
            ));

            Transfer shop1gaKirim = transferRepository.save(new Transfer(
                    mainSklad,
                    shop1Warehouse,
                    true
            ));

            productWithAmountRepository.save(new ProductWithAmount(
                 naushnik,
                 100,
                 mainSkladgaKirim
            ));
            productWithAmountRepository.save(new ProductWithAmount(
                 chexol,
                 100,
                 mainSkladgaKirim
            ));
            productWithAmountRepository.save(new ProductWithAmount(
                    naushnik,
                    50,
                    shop1gaKirim
            ));
            productWithAmountRepository.save(new ProductWithAmount(
                    chexol,
                    50,
                    shop1gaKirim
            ));

            Sale firstSale = saleRepository.save(new Sale(
                    shop1,
                    shop1.getSeller()
            ));

            productWithAmountRepository.save(new ProductWithAmount(
                    naushnik,
                    10,
                    firstSale
            ));
            productWithAmountRepository.save(new ProductWithAmount(
                    chexol,
                    10,
                    firstSale
            ));

            Reject reject = rejectRepository.save(new Reject(
                    shop1
            ));

            productWithAmountRepository.save(new ProductWithAmount(
                    naushnik,
                    1,
                    reject
            ));
            productWithAmountRepository.save(new ProductWithAmount(
                    chexol,
                    1,
                    reject
            ));

            Defect defect = defectRepository.save(new Defect(
                    shop1Warehouse,
                    true,
                    manager
            ));

            productWithAmountRepository.save(new ProductWithAmount(
                    naushnik,
                    3,
                    defect
            ));
            productWithAmountRepository.save(new ProductWithAmount(
                    chexol,
                    3,
                    defect
            ));
        }
    }
}
