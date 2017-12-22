package com.oakinvest.b2g.repository.bitcoin;

import com.oakinvest.b2g.domain.bitcoin.BitcoinBlock;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * BitcoinBlock repository.
 * Created by straumat on 09/09/16.
 */
@Repository
public interface BitcoinBlockRepository extends GraphRepository<BitcoinBlock> {

   /**
	 * Find a block by its height.
	 *
	 * @param height height
	 * @return block
	 */
	BitcoinBlock findByHeight(int height);

	/**
	 * Find a block by its height.
	 *
	 * @param height height
	 * @return block
	 */
	@Query("MATCH (b:BitcoinBlock) WHERE b.height= {0} return b")
	BitcoinBlock findByHeightWithoutDepth(int height);

    /**
     * Find a block by it's height get all the data.
     *
     * @param height height
     * @return block
     */
    @Query("MATCH (n:BitcoinBlock) WHERE n.height = {0} WITH n MATCH p=(n)-[*0..1]-(m)-[*0..1]-(l) RETURN p, n, m, l")
    BitcoinBlock findFullByHeight(int height);

    /**
	 * Find a block by its hash.
	 *
	 * @param hash hash
	 * @return block
	 */
	BitcoinBlock findByHash(String hash);

    /**
     * Find a block by its hash.
     *
     * @param hash hash
     * @return block
     */
    @Query("MATCH (b:BitcoinBlock) WHERE b.hash= {0} return b")
    BitcoinBlock findByHashWithoutDepth(String hash);

}
