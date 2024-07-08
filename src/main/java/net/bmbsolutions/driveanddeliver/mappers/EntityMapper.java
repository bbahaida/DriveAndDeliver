package net.bmbsolutions.driveanddeliver.mappers;

import java.util.List;


public interface EntityMapper<D, M> {
    D mapToDTO(M m);

    M mapToModel(D d);

    List<D> mapToDTO(List<M> m);

    List<M> mapToModel(List<D> d);
}
