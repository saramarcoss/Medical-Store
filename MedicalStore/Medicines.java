package MedicalStore;


/**
* MedicalStore/Medicines.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from store.idl
* Saturday, 14 April, 2018 10:58:32 AM IST
*/

public final class Medicines implements org.omg.CORBA.portable.IDLEntity
{
  public MedicalStore.MedicineInfo meds[] = null;

  public Medicines ()
  {
  } // ctor

  public Medicines (MedicalStore.MedicineInfo[] _meds)
  {
    meds = _meds;
  } // ctor

} // class Medicines