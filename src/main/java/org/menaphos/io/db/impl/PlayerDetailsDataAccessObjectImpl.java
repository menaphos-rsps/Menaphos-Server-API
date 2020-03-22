package org.menaphos.io.db.impl;

import org.menaphos.entity.impl.impl.PlayerDetails;
import org.menaphos.io.db.DatabaseAcessManager;
import org.menaphos.io.db.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PlayerDetailsDataAccessObjectImpl<D extends PlayerDetails> extends AbstractDataAcessObject<D> {

    public PlayerDetailsDataAccessObjectImpl() {
        super("players.db");
    }

    @Override
    public List<D> getAllEntries() {
        return new ArrayList<>(this.getCachedEntries().values());
    }

    @Override
    public void update(D d) {
        D cachedDetails = this.getCachedEntries().get(d.getId());
        cachedDetails = d;
    }

    @Override
    public void create(D d) {
        final Query query = new Query.QueryBuilder().addQuery("INSERT INTO")
                .addQuery("basic")
                .addQuery("(id)")
                .addQuery("VALUES(?)")
                .build();
        try (Connection conn = DatabaseAcessManager.getInstance().connect(this.getDatabaseServiceProvider().getUrl());
             PreparedStatement pstmt = Objects.requireNonNull(conn).prepareStatement(query.getSql())) {
            pstmt.setLong(1, d.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.getCachedEntries().putIfAbsent(d.getId(),d);
    }

    @Override
    public void delete(D d) {
        this.getCachedEntries().remove(d.getId());
    }

    @Override
    public D read(D d) {
        return this.getCachedEntries().get(d.getId());
    }

    @Override
    public D read(long id) {
        return this.getCachedEntries().get(id);
    }
}
