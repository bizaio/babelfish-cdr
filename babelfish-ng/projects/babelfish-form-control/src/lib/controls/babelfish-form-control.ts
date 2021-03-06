import {FormControl} from '@angular/forms';
import {BabelfishFormControlTypes} from '../babelfish-form-control.component';

export class BabelfishFormControl extends FormControl {

  type: BabelfishFormControlTypes;
  label: string;
  tooltip: string;
  isVisible = true;
  controlStyle: string;

  constructor(type: BabelfishFormControlTypes, defaultValue, label: string, tooltip: string, validators = [], controlStyle: string = "", asyncValidators = []) {
    super(defaultValue, validators, asyncValidators);

    this.type = type;
    this.label = label;
    this.tooltip = tooltip;
    this.controlStyle = controlStyle;
    this.tooltip = tooltip;
  }
}
