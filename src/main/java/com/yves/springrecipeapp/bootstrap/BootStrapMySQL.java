package com.yves.springrecipeapp.bootstrap;

import com.yves.springrecipeapp.domain.Category;
import com.yves.springrecipeapp.domain.UnitOfMeasure;
import com.yves.springrecipeapp.repositories.CategoryRepository;
import com.yves.springrecipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev", "prod"})
public class BootStrapMySQL implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootStrapMySQL(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (categoryRepository.count() == 0L) {
            loadCategories();
        }

        if (unitOfMeasureRepository.count() == 0L) {
            loadUom();
        }
    }

    private void loadCategories() {
        Category cat1 = new Category();
        cat1.setDescription("American");
        categoryRepository.save(cat1);

        Category cat2 = new Category();
        cat2.setDescription("Italian");
        categoryRepository.save(cat2);

        Category cat3 = new Category();
        cat3.setDescription("Mexican");
        categoryRepository.save(cat3);

        Category cat4 = new Category();
        cat4.setDescription("Fast Food");
        categoryRepository.save(cat4);
    }

    private void loadUom() {
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setDescription("TeaSpoon");
        unitOfMeasureRepository.save(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom1.setDescription("TableSpoon");
        unitOfMeasureRepository.save(uom2);

        UnitOfMeasure uom3 = new UnitOfMeasure();
        uom1.setDescription("Cup");
        unitOfMeasureRepository.save(uom3);

        UnitOfMeasure uom4 = new UnitOfMeasure();
        uom1.setDescription("Each");
        unitOfMeasureRepository.save(uom4);

        UnitOfMeasure uom5 = new UnitOfMeasure();
        uom1.setDescription("Pint");
        unitOfMeasureRepository.save(uom5);

        UnitOfMeasure uom6 = new UnitOfMeasure();
        uom1.setDescription("Dash");
        unitOfMeasureRepository.save(uom6);
    }
}
