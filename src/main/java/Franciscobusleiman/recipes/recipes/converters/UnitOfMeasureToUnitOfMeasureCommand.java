package Franciscobusleiman.recipes.recipes.converters;

import Franciscobusleiman.recipes.recipes.commands.UnitOfMeasureCommand;
import Franciscobusleiman.recipes.recipes.domain.UnitOfMeasure;
import com.sun.istack.Nullable;
import org.springframework.core.convert.converter.Converter;

public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
        if(unitOfMeasure == null){
            return null;
        }

        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(unitOfMeasure.getId());
        unitOfMeasure.setUom(unitOfMeasure.getUom());

      return unitOfMeasureCommand;
    }
}
