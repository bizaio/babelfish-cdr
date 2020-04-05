import {BabelfishFormControl} from './babelfish-form-control';
import {BabelfishFormControlTypes} from '../babelfish-form-control.component';

export class BabelfishFormInput extends BabelfishFormControl {

  subType: string;

  constructor(defaultValue, label: string, validators = [], subType = 'text', asyncValidators = []) {
    super(BabelfishFormControlTypes.INPUT, defaultValue, label, validators, asyncValidators);

    this.subType = subType;
  }
}
