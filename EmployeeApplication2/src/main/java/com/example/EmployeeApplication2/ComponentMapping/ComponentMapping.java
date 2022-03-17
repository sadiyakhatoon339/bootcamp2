package com.example.EmployeeApplication2.ComponentMapping;

import javax.persistence.Embeddable;


@Embeddable
public class ComponentMapping {

    public ComponentMapping() {}

    int basicSalary, bonusSalary, taxAmount, specialAllowancesalary;

        public int getBasicSalary() {
            return basicSalary;
        }

        public void setBasicSalary(int basicsalary) {
            this.basicSalary = basicsalary;
        }

        public int getBonusSalary() {
            return bonusSalary;
        }

        public void setBonusSalary(int bonussalary) {
            this.bonusSalary = bonussalary;
        }

        public int getTaxAmount() {
            return taxAmount;
        }

        public void setTaxAmount(int taxamount) {
            this.taxAmount = taxamount;
        }

        public int getSpecialallowancesalary() {
            return specialAllowancesalary;
        }

        public void setSpecialallowancesalary(int specialAllowancesalary) {
            this.specialAllowancesalary = specialAllowancesalary;
        }
}
